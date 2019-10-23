package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    long currentId = 1L;
    Map<Long, TimeEntry> timeEntryMap = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(currentId);
        timeEntryMap.put(currentId, timeEntry);
        currentId++;
        return timeEntry;
    }


    public TimeEntry find(Long timeEntryId) {

        return timeEntryMap.get(timeEntryId);
    }

    public List<TimeEntry> list() {

        return new ArrayList<TimeEntry>(timeEntryMap.values());

    }

    public TimeEntry update( Long id,TimeEntry timeEntry ){

        TimeEntry data = timeEntryMap.get(id);

            if(data == null){
                return null;
            }

        timeEntry.setId(id);
        timeEntryMap.replace(id, timeEntry);

      /*  data.setProjectId(timeEntry.getProjectId());
        data.setUserId(timeEntry.getUserId());
        data.setDate(timeEntry.getDate());
        data.setHours(timeEntry.getHours());*/
        return timeEntry;
    }

    public TimeEntry delete(Long id) {
        timeEntryMap.remove(id);
        return null;
    }

}
