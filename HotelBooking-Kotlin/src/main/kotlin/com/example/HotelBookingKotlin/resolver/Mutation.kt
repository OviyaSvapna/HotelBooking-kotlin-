package com.example.HotelBookingKotlin.resolver

import com.example.HotelBookingKotlin.request.*
import com.example.HotelBookingKotlin.service.HotelService
import com.example.HotelBookingKotlin.service.ReservationService
import com.example.HotelBookingKotlin.service.RoomService
import com.example.HotelBookingKotlin.service.UserService
import graphql.kickstart.tools.GraphQLMutationResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class Mutation : GraphQLMutationResolver {
    @Autowired
    lateinit var hotelService: HotelService

    @Autowired
    lateinit var reservationService: ReservationService

    @Autowired
    lateinit var roomService: RoomService

    @Autowired
    lateinit var userService: UserService

    fun createUser(createUserRequest: CreateUserRequest): String {
        var user = userService.createUser(createUserRequest)
        if (user != null) {
            return "User Account Successfully"
        }
        return "Not able to create the account"
    }

    fun createHotel(createHotelRequest: CreateHotelRequest): String {
        var hotel = hotelService.createHotel(createHotelRequest)

        if (hotel != null) {
            return "Hotel is added successfully"
        }
        return "Not able to add the hotel"
    }

    fun createRoom(createRoomRequest: CreateRoomRequest): String {
        var room = roomService.createRoom(createRoomRequest);
        if (room != null) {
            return "room is added successfully"
        }
        return "Not able to add the room"
    }

    fun bookRoom(inputReservationRequest: InputReservationRequest): List<String> {
        var status: List<String> = reservationService.bookRoom(inputReservationRequest)
        return status
    }

    fun cancelRoom(cancelRoomRequest: CancelRoomRequest): String {
        var status = reservationService.cancelRoom(cancelRoomRequest)
        if (status)
            return "Cancellation of Room is successful"
        return "Unable to cancel your Booking"
    }


}