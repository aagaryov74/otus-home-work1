package ru.otus.agaryov.dz1.csvfilereader;


import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import ru.otus.agaryov.dz1.results.IResultChecker;
import ru.otus.agaryov.dz1.results.ResultChecker;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class dz1Test {

    @Test
    void checkAnswers() {
        ICsvFileReader reader = mock(ICsvFileReader.class);
        LinkedHashMap<String,String> cMap = new LinkedHashMap<>();
        // Не написали еще чтение из файла в мапу, но уже хотим проверить, как ответопроверятель работает
        cMap.put("Сколько колес у Машины","2");
        cMap.put("Сколько ног у Мальвины","2");
        cMap.put("Сколько месяцев в году","12");
        cMap.put("Сколько деревьев в саду","21");

        when(reader.readCsvIntoMap()).thenReturn(cMap);
        // Ответопроверятель
        IResultChecker resChecker = new ResultChecker(reader);
        // Прокладка
        IResultChecker sChecker = Mockito.spy(resChecker);

        sChecker.checkAnswer("Сколько ног у Мальвины", "2");
        sChecker.checkAnswer("Сколько месяцев в году", "12");
        sChecker.checkAnswer("Сколько месяцев в году", "1");
        sChecker.checkAnswer("Сколько колес у Машины", "1");

        int res = sChecker.getResult();
        assertEquals(2,res, "Right answers must be 2!");

        verify(sChecker, times(1)).
                checkAnswer("Сколько ног у Мальвины", "2");

        verify(sChecker, never()).
                checkAnswer("Сколько деревьев в саду", "21");

        int qCount = sChecker.getQuestions().length;

        assertEquals(4,qCount,"Questions count must be 4!");

    }
}