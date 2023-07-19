const moveTarget = document.getElementById("js-moveTarget");
const moveSwitch = document.getElementById("js-moveSwitch");
const moveAction = ()=>{
    moveTarget.classList.toggle("active");
}
moveSwitch.addEventListener("click",moveAction);
/**
 * 
 */