function solution(scores) {
    const getScore = (mean) => {
        if(mean >= 90) return 'A';
        if(mean >= 80) return 'B';
        if(mean >= 70) return 'C';
        if(mean >= 50) return 'D';
        return 'F';
    };

    const getMean = (score, index) => {
        let max = -1;
        let min = 101;
        let maxCount = 1;
        let minCount = 1;

        for(let i = 0; i < score.length; i++) {
            if(score[i] > max) {
                max = score[i];
                maxCount = 1;
            } else if(score[i] === max) {
                maxCount++;
            } else if(score[i] < min) {
                min = score[i];
                minCount = 1;
            } else if(score[i] === min) {
                minCount++;
            }
        }

        let isWithoutMyScore = (score[index] === max && maxCount === 1) || (score[index] === min && minCount === 1);
        let total = 0;
        score.forEach((value, i) => {
            if(i === index && isWithoutMyScore) return;
            total += value;
        });
        return getScore(total / (isWithoutMyScore ? score.length - 1 : score.length));
    };

    let means = [];
    let length = scores.length;
    let scoresGet = [];
    for(let i = 0; i < length; i++) {
        let tmp = [];
        for(let j = 0; j < length; j++) {
            tmp.push(scores[j][i]);
        }
        scoresGet.push(tmp);
    }
    scoresGet.forEach((score, index) => {
        means.push(getMean(score, index));
    });
    return means.join('');
}