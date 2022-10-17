package com.example.HotelBookingKotlin.service

import com.example.HotelBookingKotlin.entity.HotelName_Room
import com.example.HotelBookingKotlin.entity.Room
import com.example.HotelBookingKotlin.entity.RoomByHotelNameDAO
import com.example.HotelBookingKotlin.repository.RoomRepository
import com.example.HotelBookingKotlin.request.CreateRoomRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RoomService {

    @Autowired
    lateinit var roomRepository: RoomRepository

//    @Autowired
//    lateinit var idgenerator: Flake64L

    fun createRoom(createRoomRequest: CreateRoomRequest?): Room {

        var room = Room()
        room.roomId = System.currentTimeMillis() + Math.random().toLong()
        room.roomNo = createRoomRequest?.roomNo
        room.roomPrice = createRoomRequest?.roomPrice
        room.roomType = createRoomRequest?.roomType
        room.hotelId = createRoomRequest?.hotelId
        roomRepository.save(room)
        return room
    }

    fun getRoomsByHotelId(hotelId: Long?): List<Room>? {
        var rooms: List<Room>? = roomRepository.getRoomsByHotelId(hotelId)
        if (rooms != null)
            return rooms

        return null
    }

    fun getRoomsByHotelName(hotelName: String?): List<RoomByHotelNameDAO>? {
        var rooms: List<RoomByHotelNameDAO>? = roomRepository.getRoomsByHotelName(hotelName)
        if (rooms != null)
            return rooms

        return null

    }


    fun getAllRooms(): List<HotelName_Room>? {
        var rooms: List<HotelName_Room>? = roomRepository.getAllRooms()
        if (rooms != null)
            return rooms

        return null
    }


}