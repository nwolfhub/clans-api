package org.nwolfhub.lib

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.containing
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.nwolfhub.lib.client.ClashOfClans
import org.nwolfhub.lib.request.BattleLogRequest
import org.nwolfhub.lib.request.CapitalRaidSeasonsRequest
import org.nwolfhub.lib.request.ClanRequest
import org.nwolfhub.lib.request.PlayerRequest
import org.nwolfhub.lib.request.SearchClansRequest
import org.nwolfhub.lib.request.VerifyTokenRequest
import org.nwolfhub.lib.request.battleLog
import org.nwolfhub.lib.request.capitalRaidSeasons
import org.nwolfhub.lib.request.clan
import org.nwolfhub.lib.request.player
import org.nwolfhub.lib.request.searchClans
import org.nwolfhub.lib.request.verifyToken
import org.nwolfhub.lib.response.ClashApiException
import org.nwolfhub.lib.response.Player

private const val TAG = "ABC123"

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ClashOfClansTest {

    private lateinit var server: WireMockServer
    private lateinit var client: ClashOfClans

    @BeforeAll
    fun start() {
        server = WireMockServer(WireMockConfiguration.options().dynamicPort())
        server.start()
        client = ClashOfClans("test-token")
        client.baseUrl = server.baseUrl()
    }

    @AfterAll
    fun stop() {
        server.stop()
    }

    @Test
    fun `player parses single object response`() {
        stubFor(
            get(urlEqualTo("/players/$TAG")).willReturn(
                okJson(
                    """
                    {
                      "tag": "#$TAG",
                      "name": "John",
                      "expLevel": 12,
                      "trophies": 4000,
                      "attackWins": 100,
                      "defenseWins": 50,
                      "townHallLevel": 14
                    }
                    """.trimIndent(),
                ),
            ),
        )

        val player: Player = client.player(PlayerRequest(TAG))

        assertEquals("#$TAG", player.tag)
        assertEquals("John", player.name)
        assertEquals(12, player.expLevel)
        assertEquals(4000, player.trophies)
        assertEquals(200, player.code)
        assertNotNull(player.rawResponse)
    }

    @Test
    fun `verify token sends auth header and json body`() {
        stubFor(
            post(urlEqualTo("/players/$TAG/verifytoken"))
                .willReturn(okJson("""{"tag":"#ABC123","token":"ok","status":"ok"}""")),
        )

        client.verifyToken(VerifyTokenRequest(TAG, "some-token"))

        verify(
            postRequestedFor(urlEqualTo("/players/$TAG/verifytoken"))
                .withHeader("Authorization", equalTo("Bearer test-token"))
                .withRequestBody(containing("some-token")),
        )
    }

    @Test
    fun `search clans sends query parameters`() {
        stubFor(
            get(urlPathEqualTo("/clans"))
                .withQueryParam("name", equalTo("foo"))
                .withQueryParam("minClanLevel", equalTo("5"))
                .withQueryParam("limit", equalTo("10"))
                .willReturn(
                    okJson(
                        """
                        [
                          { "name": "Clan A", "tag": "#A", "clanLevel": 6 },
                          { "name": "Clan B", "tag": "#B", "clanLevel": 7 }
                        ]
                        """.trimIndent(),
                    ),
                ),
        )

        val clans = client.searchClans(
            SearchClansRequest(name = "foo", minClanLevel = 5, limit = 10),
        )

        assertEquals(2, clans.size)
        assertEquals("Clan A", clans[0].name)
        assertEquals(6, clans[0].clanLevel)
    }

    @Test
    fun `clan parses nested objects`() {
        stubFor(
            get(urlEqualTo("/clans/$TAG")).willReturn(
                okJson(
                    """
                    {
                      "tag": "#$TAG",
                      "name": "My Clan",
                      "clanLevel": 10,
                      "warLeague": { "id": 48000018, "name": "Master League I" },
                      "capitalLeague": { "id": 85000009, "name": "Champion League II" }
                    }
                    """.trimIndent(),
                ),
            ),
        )

        val clan = client.clan(ClanRequest(TAG))

        assertEquals("My Clan", clan.name)
        assertEquals(10, clan.clanLevel)
        assertEquals("Master League I", clan.warLeague?.name)
        assertEquals(85000009, clan.capitalLeague?.id)
    }

    @Test
    fun `battle log parses list response`() {
        stubFor(
            get(urlPathEqualTo("/players/$TAG/battlelog")).willReturn(
                okJson(
                    """
                    [
                      { "battleType": "RANKED", "stars": 3, "destructionPercentage": 100 },
                      { "battleType": "HOME_VILLAGE", "stars": 1, "destructionPercentage": 45 }
                    ]
                    """.trimIndent(),
                ),
            ),
        )

        val log = client.battleLog(BattleLogRequest(TAG))

        assertEquals(2, log.size)
        assertEquals(3, log[0].stars)
        assertEquals(100, log[0].destructionPercentage)
    }

    @Test
    fun `capital raid seasons parses list response`() {
        stubFor(
            get(urlPathEqualTo("/clans/$TAG/capitalraidseasons")).willReturn(
                okJson(
                    """
                    [
                      { "state": "ended", "totalAttacks": 60, "raidsCompleted": 10 },
                      { "state": "ongoing", "totalAttacks": 20, "raidsCompleted": 3 }
                    ]
                    """.trimIndent(),
                ),
            ),
        )

        val seasons = client.capitalRaidSeasons(CapitalRaidSeasonsRequest(TAG))

        assertEquals(2, seasons.size)
        assertEquals("ended", seasons[0].state)
        assertEquals(60, seasons[0].totalAttacks)
    }

    @Test
    fun `non 2xx response throws ClashApiException with parsed error`() {
        stubFor(
            get(urlEqualTo("/clans/$TAG/nonexistent")).willReturn(
                WireMock.aResponse()
                    .withStatus(404)
                    .withHeader("Content-Type", "application/json")
                    .withBody("""{"reason":"notFound","message":"Clan not found"}"""),
            ),
        )

        val exception = assertThrows(ClashApiException::class.java) {
            client.execute(
                "GET",
                "/clans/$TAG/nonexistent",
                clazz = Player::class.java,
            )
        }

        assertEquals(404, exception.code)
        assertEquals("notFound", exception.error?.reason)
        assertEquals("Clan not found", exception.error?.message)
    }

    @Test
    fun `forbidden response is parsed as ClientError`() {
        stubFor(
            get(urlEqualTo("/players/$TAG")).willReturn(
                WireMock.aResponse()
                    .withStatus(403)
                    .withHeader("Content-Type", "application/json")
                    .withBody(
                        """
                        {
                          "reason": "accessDenied",
                          "message": "Access denied",
                          "type": "about:blank"
                        }
                        """.trimIndent(),
                    ),
            ),
        )

        val exception = assertThrows(ClashApiException::class.java) {
            client.player(PlayerRequest(TAG))
        }

        assertEquals(403, exception.code)
        assertEquals("accessDenied", exception.error?.reason)
        assertEquals("Access denied", exception.error?.message)
    }
}
