package com.example.HotelBookingKotlin.entity


import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name = "user")
class User {

    @Id
    @Column(name = "user_id ")
    var userId: Long? = null

    @field:Column(name = "username")
    var userName: String? = null

    @field:Column(name = "firstname")
    var firstName: String? = null

    @field:Column(name = "lastname")
    var lastName: String? = null

    @field:Column(name = "email")
    var email: String? = null

    @field:Column(name = "account_type")
    var accountType: String? = null

    @field:Column(name = "mobile_no")
    var mobileNo: String? = null

}