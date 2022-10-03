package com.sparta.week3.controller;

import com.sparta.week3.domain.Memo;
import com.sparta.week3.dto.MemoRequestDto;
import com.sparta.week3.repository.MemoRepository;
import com.sparta.week3.service.MemoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.predicate.MemberOfPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //Create
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memoRepository.save(memo);
    }
    //Read
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        //return memoRepository.findAllByOrderByModifiedAtDesc();
        return memoRepository.findAllByOrderByCreatedTimeDesc();
    }
    //Read 2 개별
    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getMemos(@PathVariable Long id) {
        return memoRepository.findById(id);

    }
    //Delete
    @DeleteMapping("/api/memos/{id}")
    public boolean deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        //원래 password 프린트, 그 값을 checkString에 삽입
        //그전 레포지토리 get
        Memo tempMemo=memoRepository.findById(id).orElseThrow( () -> new NullPointerException("id가 존재하지 않습니다."));
        String checkString = tempMemo.getPassword();
        // 새로운 메모를 만들고

        if((requestDto.getPassword().equals(checkString))){
        memoRepository.deleteById(id);
            return true;}
        else{
            System.out.println("비밀번호가 다릅니다");
        }
        return false;

    }
    //CheckPassword
    @PostMapping("/api/memos/{id}")
    public boolean checkMemo(@PathVariable Long id,@RequestBody MemoRequestDto requestDto) {
        //원래 password 프린트, 그 값을 checkString에 삽입
        //그전 레포지토리 get
        Memo tempMemo2=memoRepository.findById(id).orElseThrow( () -> new NullPointerException("id가 존재하지 않습니다."));
        String checkString2 = tempMemo2.getPassword();

        // 새로운 메모를 만들고

        if((requestDto.getPassword().equals(checkString2))) {
            System.out.println("비밀번호가 맞습니다");
            return true;
        }
        else{
            System.out.println("비밀번호가 다릅니다");
        }
        return false;
    }

    //Update
    @PutMapping("/api/memos/{id}")
    public Optional<Memo> updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return memoRepository.findById(id);
    }
}