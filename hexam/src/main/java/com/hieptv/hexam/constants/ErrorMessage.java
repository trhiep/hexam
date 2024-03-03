package com.hieptv.hexam.constants;

/**
 * @author trhiep
 */
public interface ErrorMessage {

    interface Answer {
        String NOT_EMPTY_TITLE = "Nội dung câu trả lời không được bỏ trống!";
    }

    interface Classes {
        String NOT_EMPTY_CLASS_NAME = "Tên lớp học không được bỏ trống!";
    }

    interface ExamQuestion {
        String NOT_EMPTY_CONTENT = "Nội dung câu hỏi không được bỏ trống!";
    }

    interface ExamSettings {
        String NOT_EMPTY_EXAM_NAME = "Tên bài thi không được bỏ trống!";
        String NOT_EMPTY_PUBLICATION = "Chế độ hiển thị của bài thi không được bỏ trống!";
        String NOT_EMPTY_DURATION = "Thời gian làm bài không được bỏ trống!";
        String NOT_EMPTY_PASS_SCORE = "Điểm đạt không được bỏ trống!";
    }

    interface Person {
        String NOT_EMPTY_USERNAME = "Tên người dùng không được bỏ trống!";
        String NOT_EMPTY_EMAIL = "Địa chỉ email không được bỏ trống!";
    }
}
