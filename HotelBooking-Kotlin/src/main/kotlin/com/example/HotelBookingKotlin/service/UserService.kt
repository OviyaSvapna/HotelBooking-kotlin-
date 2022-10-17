package com.example.HotelBookingKotlin.service

import com.example.HotelBookingKotlin.entity.User
import com.example.HotelBookingKotlin.repository.UserRepository
import com.example.HotelBookingKotlin.request.CreateUserRequest
import net.mguenther.idem.flake.Flake64L
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

//    @Autowired
//    lateinit var idgenerator: Flake64L

    fun createUser(createUserRequest: CreateUserRequest?): User {
        var user = User()
        user.userId = System.currentTimeMillis() + Math.random().toLong()
        user.userName = createUserRequest?.userName
        user.firstName = createUserRequest?.firstName
        user.lastName = createUserRequest?.lastName
        user.email = createUserRequest?.email
        user.accountType = createUserRequest?.accountType
        user.mobileNo = createUserRequest?.mobileNo
        user = userRepository.save(user)
        return user

    }
}