public class Tweet {
    int userid, tweetid, timestamp;

    public Tweet(int userid, int tweetid, int timestamp) {
        this.userid = userid;
        this.tweetid = tweetid;
        this.timestamp = timestamp;
    }
}

class Twitter {
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweetMap;
    int time;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(userId, tweetId, time++);
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        if (!followMap.containsKey(userId)) {
            followMap.put(userId, new HashSet<>());
        }

        PriorityQueue<Tweet> newsFeed = new PriorityQueue<>((a,b) -> Integer.compare(b.timestamp, a.timestamp));

        for (Tweet tweet : tweetMap.get(userId)) {
            newsFeed.add(tweet);
        }

        for (int followee : followMap.get(userId)) {
            for (Tweet tweet : tweetMap.get(followee)) {
                newsFeed.add(tweet);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<10 && !newsFeed.isEmpty(); i++) {
            result.add(newsFeed.poll().tweetid);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }
}
