package Models

data class CityInfoResponse(
    val location: String,
    val hotels: List<Hotel>,
    val restaurants: List<Restaurant>,
    val pois: List<Poi>
) {
    data class Hotel(val hotel_name: String, val address: String)
    data class Restaurant(val name: String, val address: String)
    data class Poi(val name: String, val address: String)
}