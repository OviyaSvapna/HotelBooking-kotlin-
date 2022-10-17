package com.example.HotelBookingKotlin.entity

import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "hotel")
class Hotel {

    @Id
    @Column(name = "hotel_id ")
    var hotelId: Long? = null

    @Column(name = "hotel_name")
    var hotelName: String? = null

    @Column(name = "address ")
    var address: String? = null

    @Column(name = "city")
    var city: String? = null

    @Column(name = "state ")
    var state: String? = null

//    @OneToMany(mappedBy = "hotel", cascade = [CascadeType.ALL])
//    private val rooms: List<Room>? = null

}