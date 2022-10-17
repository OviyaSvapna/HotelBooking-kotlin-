package com.example.HotelBookingKotlin.request

import lombok.Getter
import lombok.Setter

@Getter
@Setter
class CreateHotelRequest {

    lateinit var hotelName: String

    lateinit var address: String

    lateinit var city: String

    lateinit var state: String

}