package com.example.HotelBookingKotlin.resolver

import com.example.HotelBookingKotlin.entity.HotelName_Room
import com.example.HotelBookingKotlin.entity.Room
import com.example.HotelBookingKotlin.entity.RoomByHotelNameDAO
import com.example.HotelBookingKotlin.service.HotelService
import com.example.HotelBookingKotlin.service.ReservationService
import com.example.HotelBookingKotlin.service.RoomService
import com.example.HotelBookingKotlin.service.UserService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class Query : GraphQLQueryResolver {

    @Autowired
    lateinit var hotelService: HotelService

    @Autowired
    lateinit var reservationService: ReservationService

    @Autowired
    lateinit var roomService: RoomService

    @Autowired
    lateinit var userService: UserService

    fun getUserId(userId: Long?): Boolean? {
        return true
    }

    fun getRoomId(roomId: Long?): Boolean? {
        return true
    }

    fun getHotelId(hotelId: Long?): Boolean? {
        return true
    }

    fun getReservationId(reservationId: Long?): Boolean? {
        return true
    }

    fun getRoomsByHotelId(hotelId: Long?): List<Room>? {
        var rooms: List<Room>? = roomService.getRoomsByHotelId(hotelId)
        if (rooms != null) {
            return rooms
        }
        return null
    }

    fun getRoomsByHotelName(hotelName: String?): List<RoomByHotelNameDAO>? {
        var rooms: List<RoomByHotelNameDAO>? = roomService.getRoomsByHotelName(hotelName)
        if (rooms != null) {
            return rooms
        }
        return null
    }

    fun getAllRooms(): List<HotelName_Room>? {
        var rooms: List<HotelName_Room>? = roomService.getAllRooms()
        if (rooms != null) {
            return rooms
        }
        return null
    }


}