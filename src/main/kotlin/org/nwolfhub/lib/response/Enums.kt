package org.nwolfhub.lib.response

enum class WarState {
    CLAN_NOT_FOUND,
    ACCESS_DENIED,
    NOT_IN_WAR,
    IN_MATCHMAKING,
    ENTER_WAR,
    MATCHED,
    PREPARATION,
    WAR,
    IN_WAR,
    ENDED,
}

enum class PlayerRole {
    NOT_MEMBER,
    MEMBER,
    LEADER,
    ADMIN,
    COLEADER,
}

enum class PlayerHouseElementType {
    GROUND,
    ROOF,
    FOOT,
    DECO,
}

enum class BattleModifier {
    NONE,
    HARD_MODE,
    MINUS_ONE,
    MINUS_TWO,
    MINUS_THREE,
}

enum class WarFrequency {
    UNKNOWN,
    ALWAYS,
    MORE_THAN_ONCE_PER_WEEK,
    ONCE_PER_WEEK,
    LESS_THAN_ONCE_PER_WEEK,
    NEVER,
    ANY,
}

enum class ClanType {
    OPEN,
    INVITE_ONLY,
    CLOSED,
}

enum class BattleType {
    HOME_VILLAGE,
    RANKED,
    LEGEND,
}

enum class ClanWarResult {
    LOSE,
    WIN,
    TIE,
}

enum class ClanWarLeagueGroupState {
    GROUP_NOT_FOUND,
    NOT_IN_WAR,
    PREPARATION,
    WAR,
    ENDED,
}

enum class WarPreference {
    OUT,
    IN,
}

enum class Village {
    HOME_VILLAGE,
    BUILDER_BASE,
    CLAN_CAPITAL,
}
