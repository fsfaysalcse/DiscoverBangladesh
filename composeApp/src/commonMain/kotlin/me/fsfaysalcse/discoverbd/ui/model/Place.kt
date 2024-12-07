package me.fsfaysalcse.discoverbd.ui.model

data class Place(
    val id: Int,
    val name: String,
    val distance: String,
    val image: String
)

//bangladesh popular paces
val PLACES = listOf(
    Place(
        id = 1,
        name = "National Martyrs' Monument",
        distance = "12.3 km",
        image = "https://lh3.googleusercontent.com/p/AF1QipPSZzHm2RLgKNjVYOH3vDi54ZuFxxrsqNKtMFln=s1360-w1360-h1020-rw"
    ),
    Place(
        id = 2,
        name = "Lalbagh Fort",
        distance = "7.3 km",
        image = "https://lh3.googleusercontent.com/proxy/T_zgqIsfN9qoqSKSn0BlGaphTSi-cbc0oRZy_4AaJZ_85uGpoU3yySohlNHbOa5H-O5wqFGMctnizkuq9a-IPI_t0bttS3B4y6pnwfBZ5GBV5B-XoPYS6VJCKOQR7tatXeaoma6TkznfUoGsKahMXFZIEde0t1k=s1360-w1360-h1020-rw"
    ),
    Place(
        id = 3,
        name = "Sajek Valley",
        distance = "120.3 km",
        image = "https://lh3.googleusercontent.com/p/AF1QipMT07f24LgquOqz6H_IBzv2zdv-Mn3ydvHwfpLs=s1360-w1360-h1020-rw"
    ),
    Place(
        id = 4,
        name = "Rangamati",
        distance = "120.3 km",
        image = "https://lh3.googleusercontent.com/p/AF1QipMVmolNof13ycZzHl6fdHSxq7iMBqXzjwn1gMfl=s1360-w1360-h1020-rw"
    ),

    Place(
        id = 5,
        name = "Saint Martin",
        distance = "120.3 km",
        image = "https://lh3.googleusercontent.com/p/AF1QipPC9KBQccpTYPbIX17u7usY7HILQ-pfIjqKuUwT=s1360-w1360-h1020"
    )
)

val PACES2 = listOf(
    Place(
        id = 1,
        name = "Sylet",
        distance = "12.3 km",
        image = "https://wander-lush.org/wp-content/uploads/2022/03/Most-eautiful-places-in-Bangladesh-WMC-Sylhet.jpg"
    ),
    Place(
        id = 2,
        name = "Old Dhaka",
        distance = "7.3 km",
        image = "https://wander-lush.org/wp-content/uploads/2022/03/Most-eautiful-places-in-Bangladesh-CP-Old-Dhaka.jpg"
    ),
    Place(
        id = 3,
        name = "Satkhira",
        distance = "120.3 km",
        image = "https://wander-lush.org/wp-content/uploads/2022/03/Most-eautiful-places-in-Bangladesh-CP-Satkhira.jpg"
    ),
    Place(
        id = 4,
        name = "Sundarbans",
        distance = "120.3 km",
        image = "https://wander-lush.org/wp-content/uploads/2022/03/Most-eautiful-places-in-Bangladesh-CP-Sundarbans-NP.jpg"
    ),

    Place(
        id = 5,
        name = "Keokradong",
        distance = "120.3 km",
        image = "https://wander-lush.org/wp-content/uploads/2022/03/Most-eautiful-places-in-Bangladesh-CP-Keokradong.jpg"
    )
)
