package com.example.HotelBookingKotlin.request

import lombok.Getter
import lombok.Setter
import javax.persistence.Column

@Getter
@Setter
class CreateUserRequest {

    lateinit var userName: String

    lateinit var firstName: String

    lateinit var lastName: String

    lateinit var email: String

    lateinit var accountType: String

    lateinit var mobileNo: String
}