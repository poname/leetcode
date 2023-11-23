class Twitter {

    int time;
    Map<Integer, List<int[]>> tweets; // userId -> Tweet [0]:tweetId, [1] : time
    Map<Integer, PriorityQueue<int[]>> feeds;
    Map<Integer, Set<Integer>> followers;
    Map<Integer, Set<Integer>> followees;

    public Twitter() {
        tweets = new HashMap<>();
        feeds = new HashMap<>();
        followers = new HashMap<>();
        followees = new HashMap<>(); 
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        register(userId);
        int[] t = new int[]{tweetId, time++};
        tweets.get(userId).add(t);
        for (int followerId : followers.get(userId)) {
            feeds.get(followerId).add(t);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>();
        if (!feeds.containsKey(userId)) {
            return Collections.emptyList();
        }
        Queue<int[]> q = feeds.get(userId);
        while (q.size()>0 && feed.size()<10) {
            feed.add(q.remove());
        }
        List<Integer> res = new ArrayList<>();
        for (int[] f : feed) {
            res.add(f[0]);
            q.add(f);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        register(followerId);
        register(followeeId);
        if (followees.get(followerId).contains(followeeId)) {
            return;
        }
        followers.get(followeeId).add(followerId);
        followees.get(followerId).add(followeeId);
        for (int[] t : tweets.get(followeeId)) {
            feeds.get(followerId).add(t);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (tweets.get(followeeId) == null) {
            return;
        }
        for (int[] t : tweets.get(followeeId)) {
            feeds.get(followerId).remove(t);
        }
    }

    private void register(int userId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        feeds.putIfAbsent(userId, new PriorityQueue<>((x,y) -> Integer.compare(y[1],x[1])));
        followers.putIfAbsent(userId, new HashSet<>(Arrays.asList(userId)));
        followees.putIfAbsent(userId, new HashSet<>(Arrays.asList(userId)));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
