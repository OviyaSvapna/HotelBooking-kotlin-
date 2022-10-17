package com.example.HotelBookingKotlin.entity

import javax.persistence.Column


interface HotelName_Room {

    var hotelName: String?
    var roomNo: Int?
    var roomPrice: String?
    var roomType: String?
}