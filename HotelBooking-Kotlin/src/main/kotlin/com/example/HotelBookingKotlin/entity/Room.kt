package com.example.HotelBookingKotlin.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "room")
class Room {

    @Id
    @Column(name = "room_id")
    var roomId: Long? = null

    @Column(name = "room_no")
    var roomNo: Int? = null

    @Column(name = "room_price")
    var roomPrice: String? = null

    @Column(name = "room_type")
    var roomType: String? = null

    @Column(name = "hotel_id")
    var hotelId: Long? = null
//    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH])
//    @JoinColumn(name = "hotel_id")
//    var hotel: Hotel? = null


}