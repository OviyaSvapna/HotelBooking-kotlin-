package com.example.HotelBookingKotlin.request

import lombok.Getter
import lombok.Setter
import java.util.*

@Getter
@Setter
class InputReservationRequest {

    val hotelId: Long? = null

    val userId: Long? = null

    var rooms: List<BookRoom> = ArrayList<BookRoom>()

}

@Getter
@Setter
class BookRoom {

    val roomId: Long? = null

    var fromDate: String? = null

    var toDate: String? = null
}
