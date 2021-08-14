function solution(absolutes, signs) {
    let answer = 0;
    absolutes.forEach((num, i) => {
        answer += num * (signs[i] ? 1 : -1);
    })
    return answer;
}