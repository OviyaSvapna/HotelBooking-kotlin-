package com.example.HotelBookingKotlin.repository

import com.example.HotelBookingKotlin.entity.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface ReservationRespository : JpaRepository<Reservation, Int> {

    @Query("select * from reservation where room_id = :roomid and hotel_id= :hotelid", nativeQuery = true)
    fun getRooms(@Param("roomid") roomid: Long?, @Param("hotelid") hotelid: Long?): List<Reservation>?

    //    @Query(
//        "SELECT * FROM reservation where " +
//                "(from_Date = :avail_check_in <= from_Date = :check_in ) AND (to_Date = :avail_check_out >= from_Date = :check_in) AND " +
//                "(from_Date = :avail_check_in <= to_Date = :check_out) AND (to_Date = :avail_check_out >= to_Date = :check_out)AND " +
//                "(from_Date = :avail_check_in >= from_Date = :check_in) AND (to_Date = :avail_check_out<= to_Date = :check_out) AND room_id =: roomid",
//        nativeQuery = true
//    )
//    @Query(
//        "SELECT * FROM reservation where " +
//                "(from_Date  <=  :check_in ) AND (to_Date >= :check_in) AND " +
//                "(from_Date  <=  :check_out) AND (to_Date >= :check_out)AND " +
//                "(from_Date  >=  :check_in) AND (to_Date <= :check_out) AND (room_id = :roomid)",
//        nativeQuery = true
//    )
//    fun checkAvailability(
//        @Param("check_in") check_in: String,
//        @Param("check_out") check_out: String,
//        @Param("roomid") roomid: Long?
//    ): List<Reservation>


    //select * from Reservation where
    // (avail_check_in <= from_date and avail_check_out >= from_date)and
    // (avail_check_in <= to_date and avail_check_out >= to_date)and
    // (avail_check_in>=from_date and avail_check_out<=to_date))


    @Query("delete from reservation where reservation_id= :reservationId and room_id =:roomId", nativeQuery = true)
    @Modifying
    @Transactional
    fun cancelRoom(@Param("reservationId") reservationId: Long?, @Param("roomId") roomId: Long?): Int


}