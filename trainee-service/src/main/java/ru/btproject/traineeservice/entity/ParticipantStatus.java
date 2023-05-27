package ru.btproject.traineeservice.entity;

public enum ParticipantStatus {
    PENDING, // ожидает автоматической проверки
    NOT_RELEVANT, // автоматический реджект системой
    RELEVANT, // прошел проверку и сейчас на этапе тестирования или карьер школы
    REJECTED, // не хватило баллов для прохода к кейс-чемпионату
    CANDIDATE, // проходит кейс-чемпионат
    INTERN // стажируется
}
