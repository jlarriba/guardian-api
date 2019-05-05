# guardian-api
A ver simple to use to The Guardian API. The Guardian API can be expored via https://open-platform.theguardian.com/explore/ after requesting an api-key. It exposes a fluent and easy to use API.

# usage
To use the API, you need to obtain an api-key from https://open-platform.theguardian.com/access/. Once you have it, you can start using the library.

The TestApi testing class is a good resource to look at the usage of the library.

Search all the news stream and return only the most recent 10 results:

```java
GuardianApi api = new GuardianApi(API_KEY);
api.search().getResults().forEach(System.out::println);
```

Search the results from the technology section and return the 20 most recent:

```java
GuardianApi api = new GuardianApi(API_KEY)
                .section("technology")
                .pageSize(20);

api.search().getResults().forEach(System.out::println);
```

Search the results of all the news stream from yesterday, and return 100 of them:

```java
GuardianApi api = new GuardianApi(API_KEY)
                .fromDate(LocalDateTime.now().minusDays(1))
                .toDate(LocalDateTime.now())
                .pageSize(100);
                
api.search().getResults().forEach(System.out::println);
```

Return the 10 most recent results of the technology section that contain the "apple" keyword:

```java
GuardianApi api = new GuardianApi(API_KEY)
                .section("technology");

api.search("linux").getResults().forEach(System.out::println);
```

# supported API
- [x] Content (Search API)
- [ ] Sections
- [ ] Tags


# disclaimer
This project is not associated in any way with The Guardian. It is provided as-is, without any kind of warranty or support.