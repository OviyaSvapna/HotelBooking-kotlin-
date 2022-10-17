package com.example.HotelBookingKotlin.repository

import com.example.HotelBookingKotlin.entity.Hotel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : JpaRepository<Hotel, Int>
