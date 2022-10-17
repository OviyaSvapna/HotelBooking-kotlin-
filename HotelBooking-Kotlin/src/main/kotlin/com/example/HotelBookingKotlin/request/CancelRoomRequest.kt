package com.example.HotelBookingKotlin.request

import lombok.Getter
import lombok.Setter

@Getter
@Setter
class CancelRoomRequest {
    var reservationId: Long? = null
    var roomId: Long? = null
}