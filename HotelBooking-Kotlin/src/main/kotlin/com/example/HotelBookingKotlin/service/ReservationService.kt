package com.example.HotelBookingKotlin.service

import com.example.HotelBookingKotlin.entity.Reservation
import com.example.HotelBookingKotlin.repository.HotelRepository
import com.example.HotelBookingKotlin.repository.ReservationRespository
import com.example.HotelBookingKotlin.repository.RoomRepository
import com.example.HotelBookingKotlin.request.BookRoom
import com.example.HotelBookingKotlin.request.CancelRoomRequest
import com.example.HotelBookingKotlin.request.InputReservationRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Service
class ReservationService {

    @Autowired
    lateinit var hotelRepository: HotelRepository

    @Autowired
    lateinit var roomRepository: RoomRepository

    @Autowired
    lateinit var reservationRepository: ReservationRespository

    /*fun bookRoom(inputReservationRequest: InputReservationRequest): Boolean {
        var reserveRoom = Reservation()
        var confirmStatus: Boolean = false

        var bookRoomsList: List<BookRoom> = inputReservationRequest.rooms

        var hotelid: Long = inputReservationRequest.hotelId!!

        var reservationid = System.currentTimeMillis() + Math.random().toLong()

        for (rb in bookRoomsList) {

            confirmStatus = false

            var roomid: Long? = rb.roomId

            var rooms: List<Reservation>? = reservationRepository.getRooms(roomid, hotelid)
            if (rooms.isNullOrEmpty()) {
                reserveRoom.id = System.currentTimeMillis() + Math.random().toLong()
                reserveRoom.reservationId = reservationid
                reserveRoom.hotelId = hotelid
                reserveRoom.roomId = roomid
                reserveRoom.userId = inputReservationRequest.userId
                reserveRoom.fromDate = rb.fromDate
                reserveRoom.toDate = rb.toDate
                reserveRoom = reservationRepository.save(reserveRoom)
                confirmStatus = true
            } else {

                val s = SimpleDateFormat("yyyy-MM-dd")

                //changing into date
                val check_in = rb.fromDate
                val check_out = rb.toDate
//
//                val check_in = s.parse(rb.fromDate)
//                val check_out = s.parse(rb.toDate)


                var reservationStatus: List<Reservation> =
                    //var reservationStatus: Boolean =
                    reservationRepository.checkAvailability(check_in!!, check_out!!, roomid)

                if (reservationStatus.isNullOrEmpty()) {
                    reserveRoom.id = System.currentTimeMillis() + Math.random().toLong()
                    reserveRoom.reservationId = reservationid
                    reserveRoom.hotelId = inputReservationRequest.hotelId
                    reserveRoom.roomId = roomid
                    reserveRoom.userId = inputReservationRequest.userId
                    reserveRoom.fromDate = rb.fromDate
                    reserveRoom.toDate = rb.toDate
                    reserveRoom = reservationRepository.save(reserveRoom)
                    confirmStatus = true
                }
            }

        }
        return confirmStatus
    }*/

    fun bookRoom(inputReservationRequest: InputReservationRequest): List<String> {
        var reserveRoom = Reservation()

        var confirmStatus: ArrayList<String> = ArrayList<String>()

        var bookRoomsList: List<BookRoom> = inputReservationRequest.rooms

        var hotelid: Long = inputReservationRequest.hotelId!!

        var reservationid = System.currentTimeMillis() + Math.random().toLong()

        for (rb in bookRoomsList) {

            var roomid: Long? = rb.roomId
            var roomNo = roomRepository.getRoomNo(roomid)

            var rooms: List<Reservation>? = reservationRepository.getRooms(roomid, hotelid)
            if (rooms.isNullOrEmpty()) {
                reserveRoom.id = System.currentTimeMillis() + Math.random().toLong()
                reserveRoom.reservationId = reservationid
                reserveRoom.hotelId = hotelid
                reserveRoom.roomId = roomid
                reserveRoom.userId = inputReservationRequest.userId
                reserveRoom.fromDate = rb.fromDate
                reserveRoom.toDate = rb.toDate
                reserveRoom = reservationRepository.save(reserveRoom)
                confirmStatus.add("$roomNo is booked successfully")

            } else {

                for (room in rooms) {
                    val s = SimpleDateFormat("yyyy-MM-dd")
                    val cin: String? = room.toDate
                    val cout: String? = room.fromDate

                    //changing into date
                    val check_in: Date = s.parse(rb.fromDate)
                    val check_out: Date = s.parse(rb.toDate)

                    val avail_check_in: Date = s.parse(cin)
                    val avail_check_out: Date = s.parse(cout)

                    var reservestatus: Boolean = true

                    if (check_in.compareTo(avail_check_in) >= 0 && check_in.compareTo(avail_check_out) <= 0)
                        reservestatus = false

                    if (check_out.compareTo(avail_check_in) >= 0 && check_out.compareTo(avail_check_out) <= 0)
                        reservestatus = false

                    if (check_in.compareTo(avail_check_in) <= 0 && check_out.compareTo(avail_check_out) >= 0)
                        reservestatus = false
// < before  >after
                    if (reservestatus) {
                        reserveRoom.id = System.currentTimeMillis() + Math.random().toLong()
                        reserveRoom.reservationId = reservationid
                        reserveRoom.hotelId = inputReservationRequest.hotelId
                        reserveRoom.roomId = roomid
                        reserveRoom.userId = inputReservationRequest.userId
                        reserveRoom.fromDate = rb.fromDate
                        reserveRoom.toDate = rb.toDate
                        reserveRoom = reservationRepository.save(reserveRoom)
                        confirmStatus.add("$roomNo is booked successfully")
                    } else {
                        confirmStatus.add("Unable to book this room $roomNo")
                    }
                }
            }
        }
        return confirmStatus
    }


    fun cancelRoom(cancelRoomRequest: CancelRoomRequest): Boolean {
        var reservationId = cancelRoomRequest.reservationId
        var roomId = cancelRoomRequest.roomId
        var status: Int = reservationRepository.cancelRoom(reservationId, roomId)
        if (status > 0)
            return true
        return false
    }

}