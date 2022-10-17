package com.example.HotelBookingKotlin.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "reservation")
class Reservation {

    @Id
    @Column(name = "id ")
    var id: Long? = null

    @Column(name = "reservation_id")
    var reservationId: Long? = null

    @Column(name = "hotel_id")
    var hotelId: Long? = null

    @Column(name = "user_id")
    var userId: Long? = null

    @Column(name = "room_id")
    var roomId: Long? = null

    @Column(name = "from_date")
    var fromDate: String? = null

    @Column(name = "to_date")
    var toDate: String? = null


}