package com.lewns2.backend.config;

import com.lewns2.backend.repository.BoardRepository;
import com.lewns2.backend.repository.jpa.JpaBoardRepositoryImpl;
import com.lewns2.backend.repository.memory.MemoryBoardRepositoryImpl;
import com.lewns2.backend.service.BoardService;
import com.lewns2.backend.service.BoardServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public BoardRepository boardRepository() {
        return new JpaBoardRepositoryImpl();
    }

    @Bean
    public BoardService boardService() {
        return new BoardServiceImpl(boardRepository());
    }
}
