function move(moveInfo) {
    $.ajax({
        type: 'POST',
        url: '/api/move',
        data: JSON.stringify(moveInfo),
        dataType: 'json',
        contentType:'application/json; charset=utf-8',
        success: getSuccess()
    });
}

function getSuccess() {
    location.href = location.href
}

function init() {
    let isFrom = true;
    const moveInfo = new Object();
    $(`.box`).on(`click`, (event) => {
        console.log("click");
        if (isFrom) {
            moveInfo.from = event.target.id;
            console.log(moveInfo.from);
            isFrom = false;
        }
        else if (!isFrom) {
            moveInfo.to = event.target.id;
            console.log(moveInfo.to);
            isFrom = true;
            move(moveInfo);
        }
    })
}

init();