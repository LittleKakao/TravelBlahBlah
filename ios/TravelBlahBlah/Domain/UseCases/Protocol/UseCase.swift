//
//  UseCase.swift
//  TravelBlahBlah
//
//  Created by BBangGiJin on 12/28/23.
//

import Foundation

protocol UseCase {
    @discardableResult
    func start() -> Cancellable?
}
