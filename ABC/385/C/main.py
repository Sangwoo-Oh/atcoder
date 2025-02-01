n = int(input())
h = list(map(int, input().split()))

dp = [[0] * (n+1)] * (n+1)

for i in range(1, n+1):
    for j in range(1, n+1):
        if i < j:
            continue
        if h[i-1] == h[i-j-1]:
            dp[i][j] = dp[i-1][j] + 1
        else:
            dp[i][j] = 1

res = 0
for i in range(1, n+1):
    res = max(res, dp[n][i])

print(res)
# print(dp)