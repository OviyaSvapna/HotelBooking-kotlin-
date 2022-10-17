package com.example.HotelBookingKotlin.service

import com.example.HotelBookingKotlin.entity.Hotel
import com.example.HotelBookingKotlin.repository.HotelRepository
import com.example.HotelBookingKotlin.request.CreateHotelRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HotelService {

    @Autowired
    lateinit var hotelRepository: HotelRepository


    fun createHotel(createHotelRequest: CreateHotelRequest?): Hotel {
        var hotel = Hotel()
        hotel.hotelId = System.currentTimeMillis() + Math.random().toLong()
        hotel.hotelName = createHotelRequest?.hotelName
        hotel.address = createHotelRequest?.address
        hotel.city = createHotelRequest?.city
        hotel.state = createHotelRequest?.state
        hotelRepository.save(hotel)
        return hotel
    }
}