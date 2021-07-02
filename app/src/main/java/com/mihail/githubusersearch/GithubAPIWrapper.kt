package com.mihail.githubusersearch


fun submitSearchQuery(query: String): List<User> {
    if(query.isEmpty())
       return listOf()

    val u1: User = User(
        "user1",
        listOf(Repository(
                "repo1", "sample descr",
                "lang", "user1"
            )))

    val u2: User = User(
        "user2",
        listOf(
            Repository(
                "repo2", "sample descr",
                "lang", "user2"
            ),
            Repository(
                "repo3", "sample descr",
                "lang", "user2"
            )))
    if(query[0] == '1')
        return listOf(u1)
    if(query[0] == '2')
        return listOf(u2)
    return listOf(u1, u2)
}