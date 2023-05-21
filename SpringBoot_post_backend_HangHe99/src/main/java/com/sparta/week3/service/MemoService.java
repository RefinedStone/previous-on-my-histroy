package com.sparta.week3.service;

import com.sparta.week3.domain.Memo;
import com.sparta.week3.dto.MemoRequestDto;
import com.sparta.week3.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id 없습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}