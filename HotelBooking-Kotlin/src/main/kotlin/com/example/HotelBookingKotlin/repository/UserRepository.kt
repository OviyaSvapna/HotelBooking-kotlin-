package com.example.HotelBookingKotlin.repository

import com.example.HotelBookingKotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>