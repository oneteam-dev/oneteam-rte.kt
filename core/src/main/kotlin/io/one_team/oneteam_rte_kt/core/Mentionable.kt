package io.one_team.oneteam_rte_kt.core

/**
 * Mentionable model
 *
 * {
 *    id: 1,
 *    userName: "testuser",
 *    name: "testu1",
 *    email: "testuser@example.com",
 *    avatarURL: "https://www.gravatar.com/avatar/00000000000000000000000000000000?d=retro&f=y"
 * }
 */
data class Mentionable(
    val id: Int,
    val userName: String,
    val name: String,
    val email: String,
    val avatarURL: String
) {
    fun toJson() = """{ id: "$id", userName: "$userName", name: "$name", email: "$email", avatarURL: "$avatarURL" }"""
}
