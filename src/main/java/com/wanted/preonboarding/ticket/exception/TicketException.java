package com.wanted.preonboarding.ticket.exception;

import java.util.UUID;

public class TicketException extends RuntimeException {

    public TicketException(final String message) {
        super(message);
    }

    public static class ReservationNotFoundException extends TicketException {

        public ReservationNotFoundException(
                final String name,
                final String phoneNumber
        ) {
            super(String.format("조회하는 예약이 존재하지 않습니다. - request info { name : %s, phone_number : %s }",
                    name,
                    phoneNumber));
        }
    }

    public static class EnablePerformanceNotFoundException extends TicketException {

        public EnablePerformanceNotFoundException(final String isReserve) {
            super(String.format("예매 가능한 공연이 존재하지 않습니다. - request info { is_reserve : %s }", isReserve));
        }
    }

    public static class PerformanceNotFoundException extends TicketException {

        public PerformanceNotFoundException(final UUID performanceId) {
            super(String.format("조회하는 공연이 존재하지 않습니다. - request info { performance : %s }", performanceId));
        }
    }
}
