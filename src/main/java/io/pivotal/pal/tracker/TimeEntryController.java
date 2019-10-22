package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

  @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntry)
    {
        TimeEntry created = timeEntryRepository.create(timeEntry);
        return new ResponseEntity(created,HttpStatus.CREATED);

    }
    @GetMapping("{id}")
    public ResponseEntity read(@PathVariable long id) {
        Boolean founded=true;
        TimeEntry  found = timeEntryRepository.find(id);
        if(found != null){
            return new ResponseEntity(found,HttpStatus.OK);
        }else {
            return new ResponseEntity(found,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity list() {
        return new ResponseEntity(timeEntryRepository.list(),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable  long id, @RequestBody TimeEntry expected) {
        TimeEntry entry = timeEntryRepository.update(id, expected);
        if(entry !=null)
            return new ResponseEntity(entry,HttpStatus.OK);
        else
            return new ResponseEntity(entry,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id)
    {

        timeEntryRepository.delete(id);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);


    }
}
