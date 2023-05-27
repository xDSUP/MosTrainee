package ru.btproject.traineeservice.service;

public enum ParticipantSolutionStatus {
    PENDING, // ожидает проверки наставником
    FAILURE, // проверка не пройдена
    INVITED, // приглашен на стажировку
    REJECTED, // приглашение наставника отвергнуто (выбрал другую стажировку)
    APPROVED, // Подтвердил приглашение на стажировку
    RESERVED // Наставник поместил его в резерв
}
