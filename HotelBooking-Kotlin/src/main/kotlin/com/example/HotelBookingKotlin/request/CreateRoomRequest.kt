package com.example.HotelBookingKotlin.request

import com.example.HotelBookingKotlin.entity.Hotel
import lombok.Getter
import lombok.Setter

@Getter
@Setter
class CreateRoomRequest {

    var roomNo: Int = 0

    lateinit var roomPrice: String

    lateinit var roomType: String

    var hotelId: Long = 0
}