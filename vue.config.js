const { defineConfig } = require('@vue/cli-service')
const path = require('path')

module.exports = defineConfig({
  transpileDependencies: ['@boyuai/vue-clamp', 'resize-detector'],
  lintOnSave: false,
  // 设置网站标题
  chainWebpack: config => {
    config
      .plugin('html')
      .tap(args => {
        args[0].title = '考研知识共享平台'
        return args
      })
  },
  pluginOptions: {
    "style-resources-loader": {
      preProcessor: "less",
      patterns: [
        // 全局变量路径
        path.resolve(__dirname, "./src/assets/css/global.less"),
      ],
    },
  },
  //移除代理配置，使用模拟数据
  devServer: {
    // 注释掉原有的代理配置
    /*
    proxy: {
      '/': {
        target: 'http://127.0.0.1:8088',
        ws: false,
      },
    },
    */
    // 添加mock拦截器，返回空数据
    onBeforeSetupMiddleware(devServer) {
      const { app } = devServer;
      // 轮播图数据
      app.get('/video/view/randomVideos', (req, res) => {
        res.json({ code: 200, data: [] });
      });
      // 卡片数据
      app.get('/card/view/randomCardSets', (req, res) => {
        res.json({ code: 200, data: [] });
      });
      // 博客类型
      app.get('/blogs/views/getType', (req, res) => {
        res.json({ code: 200, data: [] });
      });
      // 标签数据
      app.get('/blogs/views/getTags', (req, res) => {
        res.json({ code: 200, data: [] });
      });
      // 热门博客
      app.get('/blogs/view/getBlogsHot', (req, res) => {
        res.json({ code: 200, data: [] });
      });
    }
  },
})
