class P9OutController < ApplicationController
  def index


    logger.warn session
    logger.warn session.keys
    logger.warn session.keys.size
    logger.warn session[:user_id]
    session.keys.each {|key|
      logger.warn "key:#{key}"
      logger.warn "key:#{session[key]}"
    }
    session.each {|key,value|
      logger.warn "#{key}=#{value}"
    }
    #logger.warn "user_id:#{session['warden.user.admin_user.key'][0][0]}"

  end
end
