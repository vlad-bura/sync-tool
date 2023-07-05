## How to call endpoints


Call endpoint to search for features:
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