package com.example.HotelBookingKotlin.repository

import com.example.HotelBookingKotlin.entity.HotelName_Room
import com.example.HotelBookingKotlin.entity.Room
import com.example.HotelBookingKotlin.entity.RoomByHotelNameDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : JpaRepository<Room, Long> {

    @Query("select * from room where hotel_id =:hotelId", nativeQuery = true)
    fun getRoomsByHotelId(@Param("hotelId") hotelId: Long?): List<Room>

    @Query(
        "select room.room_no as roomNo,room.room_price as roomPrice,room.room_type as roomType from room inner join hotel on room.hotel_id=hotel.hotel_id where hotel_name=:hotelName",
        nativeQuery = true
    )
    fun getRoomsByHotelName(hotelName: String?): List<RoomByHotelNameDAO>?


    @Query(
        "select hotel.hotel_name as hotelName,room.room_no as roomNo,room.room_price as roomPrice,room.room_type as roomType from room inner join hotel on room.hotel_id=hotel.hotel_id;",
        nativeQuery = true
    )
    fun getAllRooms(): List<HotelName_Room>?

    @Query("select room_no from room where room_id= :roomid", nativeQuery = true)
    fun getRoomNo(@Param("roomid") roomid: Long?): Int

}
