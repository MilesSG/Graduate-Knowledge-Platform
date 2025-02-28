<template>
  <div class="aside-boutique">
    <div class="aside-boutique-header">
      <span class="aside-boutique-title">
        <!-- <i class=""></i> -->
        <span>考研必备资源</span>
      </span>
      <!-- <span class="aside-boutique-more">
            <span>更多</span>
            <i class="el-icon-arrow-right"></i>
        </span> -->
    </div>
    <div class="aside-boutique-main">
      <div class="aside-boutique-list">
        <div class="aside-boutique-item">
          <div class="item-img">
            <img src="../../../assets/img/boutique/english.jpg" />
          </div>
          <div class="item-info">
            <div class="item-info-data">2024-02-15</div>
            <div class="item-info-title">考研英语词汇速记手册</div>
          </div>
        </div>
        <div class="aside-boutique-item">
          <div class="item-img">
            <img src="../../../assets/img/boutique/match.jpg" />
          </div>
          <div class="item-info">
            <div class="item-info-data">2024-01-23</div>
            <div class="item-info-title">高数核心公式与例题精解</div>
          </div>
        </div>
        <div class="aside-boutique-item">
          <div class="item-img">
            <img src="../../../assets/img/boutique/rabbitmq-logo.png" />
          </div>
          <div class="item-info">
            <div class="item-info-data">2024-03-10</div>
            <div class="item-info-title">计算机408考点全解析</div>
          </div>
        </div>
        <div class="aside-boutique-item">
          <div class="item-img">
            <img src="../../../assets/img/boutique/view.jpg" />
          </div>
          <div class="item-info">
            <div class="item-info-data">2024-02-28</div>
            <div class="item-info-title">考研政治马原知识点梳理</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Boutique",
  data() {
    return {};
  },
};
</script>

<style lang="less">
.aside-boutique {
  height: 510px;
  border-radius: 6px;
  border: 1px solid @levelThree-border-color;
  margin-bottom: 20px;

  .aside-boutique-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 40px;
    border-bottom: 1px solid @levelOne-border-color;
    padding: 0 10px;

    .aside-boutique-title {
      display: flex;
      align-content: center;

      span {
        font-size: 16px;
        font-weight: 600;
        color: @main-text-color;
      }
    }

    .aside-boutique-more {
      display: flex;
      align-items: center;
      color: @minor-text-color;
      font-size: 14px;
      cursor: pointer;

      i {
        font-size: 14px;
      }
    }
  }

  .aside-boutique-main {
    padding: 10px 18px;

    .aside-boutique-list {
      display: flex;
      align-content: center;
      flex-wrap: wrap;

      .aside-boutique-item {
        width: 100%;
        height: 100px;
        margin-bottom: 16px;
        position: relative;
        overflow: hidden;
        border-radius: 5px;
        cursor: pointer;

        &:hover .item-img img {
          transform: translate(-50%, -50%) scale(1.2);
        }

        &:last-child {
          margin-bottom: 0px;
        }

        .item-img {
          position: absolute;
          top: 0;
          left: 0;
          right: 0;
          bottom: 0;
          -o-object-fit: cover;
          object-fit: cover;
          background-position-x: center;
          background-position-y: center;
          background-size: cover;

          img {
            width: 100%;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
            height: auto;
            position: absolute;
            transition: all 0.5s;
          }
        }

        .item-info {
          z-index: 1;
          background: linear-gradient(180deg, transparent, rgba(0, 0, 0, 0.8));
          position: absolute;
          left: 0;
          right: 0;
          bottom: 0;
          padding: 8px !important;
          font-size: 12px;
          color: #fff;

          .item-info-data {
            font-size: 12px;
            color: #fff;
          }

          .item-info-title {
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-box-orient: vertical;
            -webkit-line-clamp: 1;
            word-break: break-word;
          }
        }
      }
    }
  }
}
</style>