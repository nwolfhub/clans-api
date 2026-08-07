package org.nwolfhub.lib.response

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

enum class WarState {
    @JsonProperty("clanNotFound")
    CLAN_NOT_FOUND,
    @JsonProperty("accessDenied")
    ACCESS_DENIED,
    @JsonProperty("notInWar")
    NOT_IN_WAR,
    @JsonProperty("inMatchmaking")
    IN_MATCHMAKING,
    @JsonProperty("enterWar")
    ENTER_WAR,
    @JsonProperty("matched")
    MATCHED,
    @JsonProperty("preparation")
    PREPARATION,
    @JsonProperty("war")
    WAR,
    @JsonProperty("inWar")
    IN_WAR,
    @JsonProperty("warEnded")
    ENDED,
}

enum class PlayerRole {
    @JsonProperty("notMember")
    NOT_MEMBER,
    @JsonProperty("member")
    MEMBER,
    @JsonProperty("leader")
    LEADER,
    @JsonProperty("admin")
    ADMIN,
    @JsonProperty("coLeader")
    COLEADER,
}

enum class PlayerHouseElementType {
    @JsonProperty("ground")
    GROUND,
    @JsonProperty("roof")
    ROOF,
    @JsonProperty("foot")
    FOOT,
    @JsonProperty("decoration")
    DECO,
    @JsonProperty("walls")
    WALLS
}

enum class BattleModifier {
    @JsonProperty("none")
    NONE,
    @JsonProperty("hardMode")
    HARD_MODE,
    @JsonProperty("minusOne")
    MINUS_ONE,
    @JsonProperty("minusTwo")
    MINUS_TWO,
    @JsonProperty("minusThree")
    MINUS_THREE,
}

enum class WarFrequency {
    @JsonProperty("unknown")
    UNKNOWN,
    @JsonProperty("always")
    ALWAYS,
    @JsonProperty("moreThanOncePerWeek")
    MORE_THAN_ONCE_PER_WEEK,
    @JsonProperty("oncePerWeek")
    ONCE_PER_WEEK,
    @JsonProperty("lessThanOncePerWeek")
    LESS_THAN_ONCE_PER_WEEK,
    @JsonProperty("never")
    NEVER,
    @JsonProperty("any")
    ANY,
}

enum class ClanType {
    @JsonProperty("open")
    OPEN,
    @JsonProperty("inviteOnly")
    INVITE_ONLY,
    @JsonProperty("closed")
    CLOSED,
}

enum class BattleType {
    @JsonProperty("homeVillage")
    HOME_VILLAGE,
    @JsonProperty("ranked")
    RANKED,
    @JsonProperty("legend")
    LEGEND,
}

enum class ClanWarResult {
    @JsonProperty("lose")
    LOSE,
    @JsonProperty("win")
    WIN,
    @JsonProperty("tie")
    TIE,
}

enum class ClanWarLeagueGroupState {
    @JsonProperty("groupNotFound")
    GROUP_NOT_FOUND,
    @JsonProperty("notInWar")
    NOT_IN_WAR,
    @JsonProperty("preparation")
    PREPARATION,
    @JsonProperty("inWar")
    WAR,
    @JsonProperty("ended")
    @JsonAlias("warEnded")
    ENDED,
}

enum class WarPreference {
    @JsonProperty("out")
    OUT,
    @JsonProperty("in")
    IN,
}

enum class Village {
    @JsonProperty("home")
    HOME_VILLAGE,
    @JsonProperty("builderBase")
    BUILDER_BASE,
    @JsonProperty("clanCapital")
    CLAN_CAPITAL,
}

enum class TokenVerificationStatus {
    @JsonProperty("invalid")
    INVALID,
    @JsonProperty("ok")
    OK
}