package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry update( Long id,TimeEntry timeEntry );
    public TimeEntry find(Long id);
    public List<TimeEntry> list();
    public TimeEntry delete(Long id );




}
