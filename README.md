## How to call endpoints


### Call endpoint to search for features:
- http://localhost:8080/api/jira/features/search  `POST`

Body:
```
{
    "jql": "project = HSP",
    "startAt": 0,
    "maxResults": 15,
    "fields": [
        "summary",
        "status",
        "assignee"
    ]
}

Info:
    *all Returns all fields.
    *navigable Returns navigable fields(default).
```

### Call endpoint to add timesheet for another person:
- http://localhost:8080/api/jira/timesheet/addWorklog  `POST`

Body:
```
{
    "timeSpentSeconds": 3600,
    "billedSeconds": 3600,
    "dateStarted": "2023-07-06",
    "comment": "ia de aci",
    "author": {
        "name": "andrei.havasi"
    },
    "issue": {
        "key": "EIO-243"
    }
}
```

### Call endpoint to delete timesheet:
- http://localhost:8080/api/jira/timesheet/delete/{worklogId}  `DELETE`