package com.hexam.constants;

/**
 * @author trhiep
 */
public interface WebErrorMessage {

    interface LoginError {
        String INVALID_USERNAME_OR_PASSWORD = "Tên đăng nhập hoặc mật khẩu không chính xác!";
    }

    interface RegisterError {
        String INVALID_FULL_NAME_LENGTH = "Họ và tên không được để trống và tối đa " + EntityConstants.Person.FULL_NAME_MAX_LENGTH + " ký tự.";
        String INVALID_USERNAME_LENGTH = "Tên người dùng không được để trống và chỉ có thể chứa ít nhất " +
                EntityConstants.Person.USER_NAME_MIN_LENGTH
                + " và tối đa " +
                EntityConstants.Person.USER_NAME_MAX_LENGTH + " ký tự.";
        String INVALID_USERNAME_FORMAT = "Tên người dùng chỉ có thể chứa chữ cái và số.";
        String EXISTED_USERNAME = "Tên người dùng đã tồn tại.";
        String INVALID_EMAIL_LENGTH = "Email không được để trống và chỉ có thể chứa tối đa " + EntityConstants.Person.EMAIL_MAX_LENGTH + " ký tự.";
        String INVALID_EMAIL_FORMAT = "Định dạng email không chính xác. Ví dụ: example@mail.com .";
        String EXISTED_EMAIL = "Email này đã tồn tại.";
        String INVALID_PASSWORD_LENGTH = "Mật khẩu phải chứa ít nhất " +
                EntityConstants.Person.PASSWORD_MIN_LENGTH
                + " và tối đa " +
                EntityConstants.Person.PASSWORD_MAX_LENGTH + " ký tự.";
        String INVALID_PASSWORD_FORMAT = "Mật khẩu phải bao gồm chữ cái, chữ số và ký tự đặc biệt.";
        String RE_PASSWORD_DOES_NOT_MATCHES = "Nhập lại mật khẩu không khớp.";
        String INVALID_REQUEST_PARAMETER = "Yêu cầu không hợp lệ. Vui lòng thử lại!";
        String NOT_ACCEPT_TERM = "Bạn cần chấp nhận thoả thuận về quyền riêng tư và bảo mật.";
    }

    interface ExamError {
        String INVALID_EXAM_NAME = "Tên bài thi phải chứa tối thiểu " + EntityConstants.Exam.EXAM_NAME_MIN_LENGTH + " và chứa tối đa " + EntityConstants.Exam.EXAM_NAME_MAX_LENGTH + " ký tự.";
        String INVALID_EXAM_DESCRIPTION = "Mô tả bài thi không thể vượt quá " + EntityConstants.Exam.EXAM_DESCRIPTION_MAX_LENGTH + " ký tự.";
        String INVALID_EXAM_DURATION = "Thời gian làm bài tối thiểu là " + EntityConstants.Exam.EXAM_MIN_DURATION + " phút và tối đa là " + EntityConstants.Exam.EXAM_MAX_DURATION + " phút.";
        String INVALID_EXAM_PASS_SCORE = "Điểm đạt tối thiểu là  " + EntityConstants.Exam.EXAM_MIN_PASS_SCORE + " điểm và tối đa là " + EntityConstants.Exam.EXAM_MAX_PASS_SCORE + " điểm.";
        String INVALID_EXAM_ATTEMPTS = "Số lần có thể làm bài tối thiểu là " + EntityConstants.Exam.EXAM_MIN_ATTEMPTS + " lần.";
        String INVALID_EXAM_PUBLICATION = "Chế độ công khai của bài thi không hợp lệ!";
        String INVALID_EXAM_DATE = "Ngày giờ không hợp lệ!";
        String INVALID_EXAM_END_DATE = "Ngày giờ không hợp lệ!";
        String SAVE_EXAM_FAILED = "Tạo bài thi mới thất bại. Vui lòng thử lại sau!";
    }
}
