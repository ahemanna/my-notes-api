package io.mynotes.mynotes.repository;

import io.mynotes.mynotes.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface NotesRepository extends JpaRepository<Note, UUID> {

    Note findByIdAndUserId(@Param("id")UUID id, @Param("user_id")String userId);

    Page<Note> findAllByUserId(@Param("user_id")String userId, Pageable pageable);

    @Transactional
    long deleteByIdAndUserId(@Param("id")UUID id, @Param("user_id")String userId);
}
