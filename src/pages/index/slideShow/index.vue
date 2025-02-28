<template>
  <div class="slideshow-wrapper">
    <el-carousel :interval="4000" height="346px" trigger="click" :autoplay="true" indicator-position="outside" class="enhanced-carousel">
      <el-carousel-item v-for="(item, index) in data" :key="index">
        <div class="item_details">
          <a>
            <img :src="item.src" />
          </a>
          <div class="trans">
            <a class="word-url">
              <h4>{{item.title}}</h4>
              <p class="item-desc">{{item.description}}</p>
            </a>
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "SlideShow",
  data() {
    return {
      data: [
        {
          src: require('../../../assets/img/slideshow/4.jpg'),
          title: '2025考研大纲发布，这些变化要知道',
          description: '及时了解最新考试大纲变化，制定有针对性的复习计划'
        },
        {
          src: require('../../../assets/img/slideshow/5.jpg'),
          title: '考研英语阅读理解高分技巧分享',
          description: '掌握阅读理解解题方法，提高英语得分率'
        },
        {
          src: require('../../../assets/img/slideshow/6.jpg'),
          title: '考研数学：高数、线代、概率论复习策略',
          description: '系统梳理数学知识点，解析典型题型和解题思路'
        },
        {
          src: require('../../../assets/img/slideshow/7.jpg'),
          title: '名校考研经验分享：从零基础到上岸清华',
          description: '优秀学长学姐分享备考经验，助你制定科学复习方案'
        },
      ]
    }
  },
};
</script>

<style lang="less">
.slideshow-wrapper {
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
}

.enhanced-carousel {
  .el-carousel__container {
    border-radius: 8px;
  }
  
  .el-carousel__indicators--outside {
    margin-top: 12px;
  }
}

@media screen and (max-width: 840px){
  .el-carousel__container{
    height: 6.1rem!important;
  }
}

.el-carousel__indicator--horizontal .el-carousel__button {
  width: 30px;
  height: 4px;
  background: rgba(255, 255, 255, 0.5);
  border-radius: 2px;
  transition: all 0.3s;
  
  @media screen and (max-width: 540px) {
    width: 20px !important;
    height: 3px !important;
  }
}

.el-carousel__indicator--horizontal.is-active {
  @media screen and (max-width: 540px) {
    .el-carousel__button{
      width: 20px !important;
      height: 3px !important;
    }
  }
  
  .el-carousel__button {
    width: 30px;
    height: 4px;
    background: #4281ff;
    border-radius: 2px;
    opacity: 1;
  }
}

.el-carousel--horizontal .el-carousel__indicators--outside {
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  
  @media screen and (max-width: 540px) {
    bottom: -10px;
  }
}

.item_details{
  width: 100%;
  height: 100%;
  position: absolute;
  opacity: 1;
  overflow: hidden;
  border-radius: 8px;
  
  a{
    display: block;
    width: 100%;
    height: 100%;

    img{
      display: block;
      width: 100%;
      height: 100%;
      border-radius: 8px;
      object-fit: cover;
      transition: transform 0.5s;
    }
    
    &:hover img {
      transform: scale(1.05);
    }
  }

  .trans{
    width: 100%;
    height: 120px;
    background: linear-gradient(180deg, transparent, rgba(0, 0, 0, 0.75));
    position: absolute;
    bottom: 0;
    left: 0;
    padding: 0 20px;
    box-sizing: border-box;

    .word-url {
      position: absolute;
      left: 20px;
      bottom: 50px;
      width: calc(100% - 40px);
      
      h4 {
        color: #fff;
        margin-top: 16px;
        font-size: 24px;
        line-height: 1.3;
        margin-bottom: 8px;
        text-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);

        @media screen and (max-width: 840px) {
          font-size: 20px;
        }

        @media screen and (max-width: 540px) {
          font-size: 16px;
        }

        @media screen and (max-width: 400px) {
          font-size: 14px;
        }
      }
      
      .item-desc {
        color: rgba(255, 255, 255, 0.9);
        font-size: 14px;
        line-height: 1.5;
        margin-bottom: 10px;
        text-shadow: 0 1px 2px rgba(0, 0, 0, 0.3);
        
        @media screen and (max-width: 540px) {
          font-size: 12px;
          display: none;
        }
      }
    }
  }
}
</style>